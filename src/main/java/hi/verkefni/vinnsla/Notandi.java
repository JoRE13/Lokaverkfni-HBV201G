package hi.verkefni.vinnsla;

public class Notandi {
    private String notendaNafn;
    private String lykilord;
    private int peningur=100;

    public Notandi(String notendanafn, String lykilord) {
        this.lykilord = lykilord;
        this.notendaNafn = notendanafn;
    }

    public int getPeningur() {
        return peningur;
    }

    public void setPeningur(int peningur) {
        this.peningur = peningur;
    }

    public String getLykilord() {
        return lykilord;
    }

    public String getNotendaNafn() {
        return notendaNafn;
    }
}
