package com.github.benchdoos.linksupport.links.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Utils for link processing
 */
class LinkUtils {

    static final String URL_PREFIX = "URL=";

    /**
     * Gets url from line that starts with URL_PREFIX
     *
     * @param inputStream to get url from
     * @return url if line with prefix exist, otherwise null
     * @throws MalformedURLException if can not parse string into url
     * @see LinkUtils#URL_PREFIX
     */
    static URL getUrl(InputStream inputStream) throws MalformedURLException {
        try (final Scanner scan = new Scanner(inputStream)) {
            while (scan.hasNext()) {
                final String next = scan.next();
                if (next.startsWith(URL_PREFIX)) {
                    char[] buffer = new char[next.length()];
                    next.getChars(4, next.length(), buffer, 0);
                    final String url = new String(buffer);
                    return new URL(url);
                }
            }
        }
        return null;
    }

    /**
     * Checks if file contains needed strings
     *
     * @param file to check
     * @param containEntryString string that is searching for
     * @return true if contains all needed : containEntryString and {@link com.github.benchdoos.linksupport.links.impl.LinkUtils#URL_PREFIX}
     */
    static boolean contains(File file, String containEntryString) {
        try (final FileInputStream fileInputStream = new FileInputStream(file);
             final Scanner scan = new Scanner(fileInputStream)) {

            boolean containEntry = false;
            boolean containsUrl = false;
            while (scan.hasNext()) {
                final String next = scan.nextLine();
                if (next.startsWith(containEntryString)) {
                    containEntry = true;
                } else if (next.startsWith(URL_PREFIX)) {
                    containsUrl = true;
                }
            }
            return containEntry && containsUrl;
        } catch (Exception e) {
            return false;
        }
    }
}
