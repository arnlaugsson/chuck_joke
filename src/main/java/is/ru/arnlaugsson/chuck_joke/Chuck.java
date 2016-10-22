package is.arnlaugsson.chuck_joke;

import net.joningi.icndb.ICNDBClient;
import net.joningi.icndb.Joke;


public class Chuck {

    final ICNDBClient client = new ICNDBClient();

    public String random() {
        Joke randomJoke = client.getRandom();
        return randomJoke.getJoke();
    }

    public String getById(String input) {
        Integer number = 0;
        try {
            number = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return null;
        }
        Joke specificJoke = client.getById(number);
        return specificJoke.getJoke();
    }

    public void alterName(String firstName, String lastName) {
        client.setFirstName(firstName);
        client.setLastName(lastName);
    }
}
