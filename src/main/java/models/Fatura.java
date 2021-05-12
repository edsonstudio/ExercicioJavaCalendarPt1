package models;
import java.util.Calendar;

public class Fatura {
    private String code;
    private Calendar expirationDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }
}
