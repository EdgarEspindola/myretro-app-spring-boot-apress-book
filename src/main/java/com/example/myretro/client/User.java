package com.example.myretro.client;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String email;
    private String name;
    private String gravatarUrl;
    private List<UserRole> userRole;
    private boolean active;
}
