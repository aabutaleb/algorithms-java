package org.aabutaleb.algorithms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataLoader {

    public static int[] read(String resourceName) throws IOException {
        List<Integer> data = new ArrayList<>();

        var url = Optional.ofNullable(ClassLoader.getSystemClassLoader().getResource(resourceName));

        if (url.isPresent()) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.get().openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(Integer.parseInt(line));
            }
        }

        return data.stream().mapToInt(i -> i).toArray();
    }
}
