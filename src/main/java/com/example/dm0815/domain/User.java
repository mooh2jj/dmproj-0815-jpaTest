package com.example.dm0815.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    cotrollerTest 때문에 오류남!
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    @ToString.Exclude
//    private List<UserHistory> userHistories = new ArrayList<>();

}
