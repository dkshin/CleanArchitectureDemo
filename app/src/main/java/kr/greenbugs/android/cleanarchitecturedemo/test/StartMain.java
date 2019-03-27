package kr.greenbugs.android.cleanarchitecturedemo.test;

import java.util.ArrayList;

/**
 * Created by SHIN on 27/03/2019.
 */
public class StartMain {

    public static void main(String[] args){
        ArrayList<NeDict> neDictArrayList = new ArrayList<>();
        neDictArrayList.add(new NeDict("바보최트루"));

        NeDictManager neDictManager = new NeDictManager(neDictArrayList);
        neDictManager.addNeDict(new NeDict("바보 시무시무"));

        neDictManager.printNedictList();

    }

}
