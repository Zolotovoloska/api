package api.client.core;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NonNull;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CookieStore implements CookieJar {
    private static final Logger LOGGER = LoggerFactory.getLogger(CookieStore.class);
    @Getter
    private final Set<Cookie> cookieStore = new HashSet<>();

    @Override
    public void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
        cookieStore.addAll(cookies);
    }

    @Override
    public List<Cookie> loadForRequest(@NonNull HttpUrl url) {
        printCookies();
        return Lists.newArrayList(cookieStore);
    }

    private void printCookies() {
        if (cookieStore.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            cookieStore.forEach(c -> stringBuilder.append(c.name()).append("=").append(c.value()).append("; "));
            LOGGER.debug("\nCookie: {}", stringBuilder.toString());
        }
    }
}


