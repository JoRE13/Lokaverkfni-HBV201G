package hi.verkefni.vinnsla;

import java.util.HashSet;

public class Notendur {

    private HashSet<String> tafla = new HashSet<>();
    public Notendur(){

    }
    public void add(Notandi u){
        tafla.add(u.getNotendaNafn());
    }

    public boolean contains(Notandi u){
        return tafla.contains(u);
    }

    public boolean legal(String userName, String password){
        Notandi u = new Notandi(userName, password);
        return tafla.contains(u);
    }
}
