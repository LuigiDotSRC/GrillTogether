package com.example.GrillTogether.meetup;

import com.example.GrillTogether.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meetup")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long meetup_id;

    @Column(length = 50)
    @Size(max = 50)
    private String title;

    @Column
    private int attendee_capacity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User createdBy;

    // TODO: implement entities for meetings_tags, meal, RSVPs

    public Meetup(String title, int attendee_capacity, User createdBy) {
        this.title = title;
        this.attendee_capacity = attendee_capacity;
        this.createdBy = createdBy;
    }
}
