package ru.vakoom.gunmarket.commondatalayer.model;

import lombok.Data;

import javax.persistence.*;

import static ru.vakoom.gunmarket.commondatalayer.model.Type.TYPE_TABLE;

@Data
@Entity
@Table(name = TYPE_TABLE)
public class Type {
    public static final String TYPE_TABLE = "type";
    public static final String TYPE_ID = "type_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TYPE_ID, length = 8, nullable = false)
    private Long typeId;

    private String upper;
    private String medium;
    private String lower;
    private String showName;
}
