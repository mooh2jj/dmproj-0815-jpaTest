package com.example.dm0815.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data // setter getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "todo")
public class TodoEntity extends BaseEntity {   // entity: table 자체인 class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mariaDB, mysql-> auto_increment
    private Long id;        // int x , Long

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Enumerated(value = EnumType.STRING)    // default oridal 0,1
    private Gender gender;

//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;

}
