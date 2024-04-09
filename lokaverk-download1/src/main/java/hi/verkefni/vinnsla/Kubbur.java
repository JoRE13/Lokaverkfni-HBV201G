package hi.verkefni.vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Kubbur {
    /**
     * Klasinn Kubbur sem "býr" til spilaborðið.
     * 
     * @author Jóhannes Reykdal Einarsson og Einar Andri Víðisson
     */
    private final String[] nums = { "einn", "tveir", "thrir", "fjorir", "fimm", "sex", "sjo", "atta", "niu" };// heldur
                                                                                                              // utan um
                                                                                                              // heitin
                                                                                                              // á
                                                                                                              // myndunum
                                                                                                              // þ.e.
                                                                                                              // nums[i-1]
                                                                                                              // hefru
                                                                                                              // nafnið
    // á mynd i
    private int radir;// tilviksbreyta fyrir fjölda raða á spilaborðinu
    private int dalkar;// tilviksbreyta fyrir fjölda dálka á spilaborðinu
    private Stykki[][] bord;// spilaborðið þ.e. tvívítt fylki af klasanum Stykki
    private SimpleStringProperty stig;// heldur utan um fjölda stiga
    private int stigint;// heldur utan um fjölda stiga sem int
    private SimpleIntegerProperty fjoldi;// heldur utan um fjölda rétt giskaðra reita.

    /**
     * Smiður fyrir klasann Kubbur. Frumstillir kubbinn og gefur stig og fjolda
     * upphafsgildi.
     * 
     * @param radir  fjöldi raða á borðinu.
     * @param dalkar fjöldi dálka á borðinu.
     */
    public Kubbur(int radir, int dalkar) {
        this.radir = radir;
        this.dalkar = dalkar;
        frumstillakubb(this.radir, this.dalkar);
        stig = new SimpleStringProperty("0");
        stigint = 0;
        fjoldi = new SimpleIntegerProperty(0);
    }

    /**
     * Gefur fjölda
     * 
     * @return fjoldi
     */
    public SimpleIntegerProperty fjoldiProperty() {
        return fjoldi;
    }

    /**
     * Gefur stig
     * 
     * @return stig
     */
    public SimpleStringProperty stigProperty() {
        return stig;
    }

    /**
     * uppfærir stig
     * 
     * @param s hve mikið á að bæta við stig
     */
    public void setStig(int s) {
        int x = Integer.parseInt(stig.getValue()) + s;
        stig.set("" + x);
        stigint = x;
    }

    public int getStig() {
        return stigint;
    }

    /**
     * uppfærir fjoldi. Bætir einum við fjölda.
     */
    public void setFjoldi() {
        fjoldi.set(fjoldi.getValue() + 1);
    }

    /**
     * Frumstillir kubbinn. Setur níu mismunandi stykkin í slembiröð í tvívíða
     * fylkið bord
     * 
     * @param radir  fjöldi raða
     * @param dalkar fjöldi dálka
     */
    private void frumstillakubb(int radir, int dalkar) {
        Stykki bord[][] = new Stykki[radir][dalkar];
        Stykki reitir[] = new Stykki[radir * dalkar];
        Boolean visited[] = new Boolean[radir * dalkar];
        for (int i = 0; i < nums.length; i++) {
            reitir[i] = new Stykki(nums[i]);
            visited[i] = false;
        }
        for (int i = 0; i < radir; i++) {
            for (int j = 0; j < radir; j++) {
                while (true) {
                    int rand = (int) (Math.random() * radir * dalkar);
                    if (!visited[rand]) {
                        bord[i][j] = reitir[rand];
                        visited[rand] = true;
                        break;
                    }
                }
            }
        }
        this.bord = bord;
    }

    /**
     * Gefur stykki í sæti (i,j) á borðinu.
     * 
     * @param i númer raðar
     * @param j númer dálks
     * @return stykki í sæti (i,j) í bord
     */
    public Stykki getBordStykki(int i, int j) {
        return bord[i][j];
    }

}
