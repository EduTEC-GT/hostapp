package gt.edu.edutec.hostapp.venue;

import gt.edu.edutec.hostapp.general.Repo;

public interface VenueRepo extends Repo {
    void getVenue(String key);
}
