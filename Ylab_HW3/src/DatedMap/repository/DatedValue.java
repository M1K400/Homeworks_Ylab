package DatedMap.repository;

import java.util.Date;

public class DatedValue {

    private String value;

    private Date dateAdd;

    public String getValue() {
        return value;
    }

    public DatedValue(String value, Date dateAdd) {
        this.value = value;
        this.dateAdd = dateAdd;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }
}
