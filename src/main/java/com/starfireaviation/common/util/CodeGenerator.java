/*
 *  Copyright (C) 2022 Starfire Aviation, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.starfireaviation.common.util;

import com.starfireaviation.common.CommonConstants;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * CodeGenerator.
 */
public class CodeGenerator {

    /**
     * ACCEPTABLE_CHARACTERS.
     */
    public static final String[] ACCEPTABLE_CHARACTERS = {
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "J",
            "K",
            "M",
            "N",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "X",
            "Y",
            "Z"
    };

    /**
     * Generates a random code of the length specified.
     *
     * @param length of the resultant code
     * @return generated code
     */
    public static String generateCode(final int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(ACCEPTABLE_CHARACTERS[getRandomNumberInRange(0, ACCEPTABLE_CHARACTERS.length - 1)]);
        }
        return sb.toString();
    }

    /**
     * Generates a random integer between min (inclusive) and max (inclusive).
     *
     * @param min minimum
     * @param max maximum
     * @return random number within range
     */
    private static int getRandomNumberInRange(final int min, final int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Produces a SHA-1 hash of the provided string.
     *
     * @param input string to be hashed
     * @return SHA-1 hash
     */
    public static String sha1Hash(final String input) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(CommonConstants.SIXTEEN);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < CommonConstants.THIRTY_TWO) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
