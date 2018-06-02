package applicationname.companydomain.fastfood.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Pizza {

    private int pID;
    private String navn, ingredienser;
    private int prisLiten, prisStor;

    private static final String KOL_NAVN_PID = "pID";
    private static final String KOL_NAVN_NAVN = "navn";
    private static final String KOL_NAVN_INGREDIENSER = "beskrivelse";
    private static final String KOL_NAVN_PRISLITEN = "prisLiten";
    private static final String KOL_NAVN_PRISSTOR = "prisStor";

    public Pizza(int pID, String navn, String ingredienser, int prisLiten, int prisStor) {
        this.pID = pID;
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.prisLiten = prisLiten;
        this.prisStor = prisStor;
    }

    public Pizza(JSONObject jsonPizza) {
        this.pID = jsonPizza.optInt("pID");
        this.navn = jsonPizza.optString("navn");
        this.ingredienser = jsonPizza.optString("ingredienser");
        this.prisLiten = jsonPizza.optInt("prisLiten");
        this.prisStor = jsonPizza.optInt("prisStor");
    }

    public JSONObject lagJSONObject () {
        JSONObject jsonPizza = new JSONObject();

        try {
            jsonPizza.put(KOL_NAVN_PID, this.pID);
            jsonPizza.put(KOL_NAVN_NAVN, this.navn);
            jsonPizza.put(KOL_NAVN_INGREDIENSER, this.ingredienser);
            jsonPizza.put(KOL_NAVN_PRISLITEN, this.prisLiten);
            jsonPizza.put(KOL_NAVN_PRISSTOR, this.prisStor);
        } catch (JSONException e) {
            return null;
        }
        return jsonPizza;

    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getIngredienser() {
        return ingredienser;
    }

    public void setIngredienser(String ingredienser) {
        this.ingredienser = ingredienser;
    }

    public int getPrisLiten() {
        return prisLiten;
    }

    public void setPrisLiten(int prisLiten) {
        this.prisLiten = prisLiten;
    }

    public int getPrisStor() {
        return prisStor;
    }

    public void setPrisStor(int prisStor) {
        this.prisStor = prisStor;
    }
}
