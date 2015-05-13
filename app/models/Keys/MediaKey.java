package models.Keys;

import play.data.validation.Constraints.Required;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class MediaKey {

    @Required
    @javax.persistence.Column(columnDefinition="varchar(32)")
    public String call_num;

    @Required
    @javax.persistence.Column(columnDefinition="integer")
    public int copy_num;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MediaKey mediaKey = (MediaKey) o;

        if (copy_num != mediaKey.copy_num) return false;
        return call_num.equals(mediaKey.call_num);

    }

    @Override
    public int hashCode() {
        int result = call_num.hashCode();
        result = 31 * result + copy_num;
        return result;
    }
}