package MVP.Part1;

public class DataModel {
    private String data;

    public DataModel(String initialData) {
        this.data = initialData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void appendData(String moreData) {
        this.data += ' ' + moreData;
    }
}
