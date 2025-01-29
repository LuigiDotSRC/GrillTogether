package com.example.GrillTogether.meetup;

import com.example.GrillTogether.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class MeetupService {

    private MeetupRepository meetupRepository;

    @Autowired
    public MeetupService(MeetupRepository meetupRepository) {
        this.meetupRepository = meetupRepository;
    }

    //TODO: create/use DTO object here?
    public Meetup createMeetup(User user, Meetup meetup) {
        return null;
    }
}
