package hi.verkefni.vinnsla;

import java.util.HashSet;

public class Notendur {

    private HashSet<Notandi> tafla = new HashSet<>();
    public Notendur(){

    }
    public void add(Notandi u){
        tafla.add(u);
    }

    public boolean contains(String userName){
        for (Notandi x : tafla) {
            if(x.getNotendaNafn().equals(userName))
                return true;
        }
        return false;
    }


    public Notandi getUser(String userName){
        for (Notandi x : tafla) {
            if(x.getNotendaNafn().equals(userName))
                return x;
        }
        return null;
    }
}
