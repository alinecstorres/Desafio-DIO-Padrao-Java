package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Temperatura {

    @Id
    @ManyToOne
    public Clima clima;

    public Clima getDescription() {
        return clima;
    }

    public void setDescription(Clima clima) {
        this.clima = clima;
    }

}
