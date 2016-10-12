package gempa.kampusdeveloper.model;

import java.util.List;

/**
 * Created by Dodi Rivaldi on 12/10/2016.
 */

public class Data {
    private String status;
    private String view;
    private String message;
    private List<Gempa> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Gempa> getData() {
        return data;
    }

    public void setData(List<Gempa> data) {
        this.data = data;
    }
}
