package fr.epita.assistants.shop.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shop")
@Getter
@Setter
@NoArgsConstructor
public class ShopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Float priceMultiplier;
    Float upgradePrice;
}
