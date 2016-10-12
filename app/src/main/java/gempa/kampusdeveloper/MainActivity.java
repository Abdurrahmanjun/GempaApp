package gempa.kampusdeveloper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import gempa.kampusdeveloper.adapter.DataGempaHolder;
import gempa.kampusdeveloper.adapter.ReycleViewAdapter;
import gempa.kampusdeveloper.api.ApiInterface;
import gempa.kampusdeveloper.model.Data;
import gempa.kampusdeveloper.model.Gempa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        GetDataGempa();
    }


    private void loading(boolean status){
        progressBar.setVisibility(status ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(status ? View.GONE : View.VISIBLE);
    }


    private void GetDataGempa(){
        loading(true);

        ApiInterface apiServices = ApiInterface.Factory.create(mContext);
        Call<Data> getData = apiServices.getDataGempa();

        getData.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data resData = response.body();

                if(resData.getStatus().equals("success")){
                    ReycleViewAdapter adapter = new ReycleViewAdapter<Gempa, DataGempaHolder>(R.layout.item_list,
                            DataGempaHolder.class, Gempa.class, resData.getData()) {
                        @Override
                        protected void bindView(DataGempaHolder holder, Gempa model, final int position) {
                            holder.bind(mContext,model);
                            holder.itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(mContext,"Data ke " + position+ " clicked!",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    };
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(mContext,resData.getMessage(),Toast.LENGTH_LONG).show();
                }
                loading(false);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(mContext,t.getMessage(),Toast.LENGTH_LONG).show();
                loading(false);
            }
        });
    }
}
