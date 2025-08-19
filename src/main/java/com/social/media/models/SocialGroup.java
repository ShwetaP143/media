package com.social.media.models;

import jakarta.persistence.*;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class SocialGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "groups")
    private Set<SocialUser> socialUser = new HashSet<>();
}

