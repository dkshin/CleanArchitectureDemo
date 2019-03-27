package kr.greenbugs.android.cleanarchitecturedemo.test;

import java.util.ArrayList;

/**
 * Created by SHIN on 27/03/2019.
 */
public class NeDictManager {

    private ArrayList<NeDict> neDictArrayList;

    public NeDictManager(ArrayList<NeDict> neDictArrayList) {
        this.neDictArrayList = neDictArrayList;
    }

    public void addNeDict(NeDict neDict){
        if(neDictArrayList != null)
            neDictArrayList.add(neDict);
        else
            neDictArrayList = new ArrayList<>();
    }

    public void printNedictList(){
        if(neDictArrayList != null){
            for (NeDict neDict : neDictArrayList) {
                System.out.println("neDict : "+ neDict.getStrNe());
            }
        }
    }
}
