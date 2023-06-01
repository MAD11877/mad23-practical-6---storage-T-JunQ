package sg.edu.np.mad.myapplication;


import java.io.Serializable;

public class User implements Serializable {
    String name;
    String description;
    int id;
    boolean followed;

    public User(){}

    public User(String n,String d,int i,boolean f)
    {
        name = n;
        description = d;
        id = i;
        followed = f;
    }

}


