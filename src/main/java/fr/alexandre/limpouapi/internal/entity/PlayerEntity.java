package fr.alexandre.limpouapi.internal.entity;

import fr.alexandre.limpouapi.i18n.Lang;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class PlayerEntity {

    @Id
    private UUID uuid;

    private String name;
    private Lang lang;

    // TODO: cache the entity at the proxy level (if the user switches servers, keep the entity in Redis)
    // update the local entity when there is a change in Redis
}
