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
}
