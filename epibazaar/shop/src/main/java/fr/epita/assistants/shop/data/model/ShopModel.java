package fr.epita.assistants.shop.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shop")
public class ShopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Float price_multiplier;
    Float upgrade_price;
}
