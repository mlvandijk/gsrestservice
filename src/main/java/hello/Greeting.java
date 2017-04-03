package hello;

/**
 * Created by maritvandijk on 4/1/17.
 */
public class Greeting {

    private long id;
    private String content;

    public Greeting(){ // no arg constructor is used by ObjectMapper

    }

    public Greeting(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent(){
        return content;
    }
}
