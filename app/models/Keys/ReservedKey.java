package models.Keys;

import models.Media;
import models.Patron;
import play.data.validation.Constraints.Required;

import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;

@Embeddable
public class ReservedKey {
    @Required
    @ManyToMany(mappedBy = "card_num")
    public Patron patron;

    @Required
    @ManyToMany(mappedBy = "call_num")
    public Media media;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservedKey that = (ReservedKey) o;

        if (!patron.equals(that.patron)) return false;
        return media.equals(that.media);

    }

    @Override
    public int hashCode() {
        int result = patron.hashCode();
        result = 31 * result + media.hashCode();
        return result;
    }
}