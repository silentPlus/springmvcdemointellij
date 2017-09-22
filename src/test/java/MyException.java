import java.util.List;

/**
 * Created by suvan on 2017/7/23.
 */
public class MyException extends Exception{
    private List data;
    public MyException(){
        super();
    }
    public MyException(List data) {
        super();
        this.data = data;
    }

    public void setData(List list) {
        this.data = data;
    }

    public List getData() {
        return data;
    }
}
