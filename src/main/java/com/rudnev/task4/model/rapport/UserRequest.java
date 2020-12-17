package com.rudnev.task4.model.rapport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String mail;
    private String password;
}
