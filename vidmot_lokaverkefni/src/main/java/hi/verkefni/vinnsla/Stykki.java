package hi.verkefni.vinnsla;

public class Stykki {
    /**
     * Klasinn Stykki sem býr til hlut sem heldur utan um hvaða mynd á að setja
     * á sérhvern reit á spilaborðinu.
     */
    private String nafn;//nafn á css hlut sem geymir mynd sem á að fara á stykkið.
    private int tala;//tilsvarandi tala fyrir myndina.

    private String[] nums =  {"einn", "tveir", "thrir", "fjorir","fimm","sex","sjo","atta","niu"};

    /**
     * Smiður fyrir klasann. Tekur inn nafn og úthlutar stykkinu tilsvarandi tölu út frá
     * nums fylkinu.
     * @param nafn nafn fyrir mynd í css skrá.
     */
    public Stykki(String nafn){
        this.nafn=nafn;
        for(int i = 0; i<nums.length; i++){
            if(nafn.equals(nums[i])){
                tala=i+1;
                break;
            }
        }
    }

    /**
     * Skilar nafn tilviksbreytunni.
     * @return nafn
     */
    public String getNafn(){
        return nafn;
    }

    /**
     * Skilar tala tilviksbreytunni.
     * @return tala
     */
    public int getTala(){
        return tala;
    }
}
