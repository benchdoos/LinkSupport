/*
 * (C) Copyright 2019.  Eugene Zrazhevsky and others.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Contributors:
 * Eugene Zrazhevsky <eugene.zrazhevsky@gmail.com>
 */

package com.github.benchdoos.weblocsupport.links;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Gives ability to create link and get url from link.
 */
public interface LinkProcessor {
    /**
     * Creates link in output stream. Closes stream after write.
     *
     * @param url to create
     * @param outputStream where to write
     */
    void createLink(URL url, OutputStream outputStream) throws IOException;

    /**
     * Gets url from input stream
     *
     * @param inputStream from where to read
     * @return url from stream
     * @throws java.io.IOException if something wrong with input-output
     * @throws java.net.MalformedURLException if url can not be parsed
     */
    URL getUrl(InputStream inputStream) throws IOException;

}
