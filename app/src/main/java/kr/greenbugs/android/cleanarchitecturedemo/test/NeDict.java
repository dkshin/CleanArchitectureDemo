package kr.greenbugs.android.cleanarchitecturedemo.test;

import java.util.Objects;

/**
 * Created by SHIN on 27/03/2019.
 */
public class NeDict {

    private String strNe;

    public NeDict(String strNe) {
        this.strNe = strNe;
    }

    public String getStrNe() {
        return strNe;
    }

    public void setStrNe(String strNe) {
        this.strNe = strNe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NeDict)) return false;
        NeDict neDict = (NeDict) o;
        return Objects.equals(strNe, neDict.strNe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strNe);
    }

    @Override
    public String toString() {
        return "NeDict{" +
                "strNe='" + strNe + '\'' +
                '}';
    }
}
