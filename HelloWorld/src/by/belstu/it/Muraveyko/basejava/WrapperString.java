package by.belstu.it.Muraveyko.basejava;

import java.util.Objects;

public class WrapperString {

private String field ;

    public WrapperString(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {

        return Objects.hash(field);
    }

    @Override
    public String toString() {
        return  field;
    }
    public void replace (char oldchar, char newchar){
       System.out.println(field.replace(oldchar,newchar));
    }

    public void delete(char y) {
    }
}
