// Author: Ethan Watts
// This is used in Battle for the arena location, which is used in
// calculating "home field advantages" based on Fighters' country
// of origin.

package com.mycompany._prog1;

public enum Arena {
  LAS_VEGAS,    // Advantage arena for BRAZIL, MEXICO, USA

  MOSCOW,       // Advantage for RUSSIA, CHINA, NORTH_KOREA

  ROME,         // Advantage for NETHERLANDS, NIGERIA. I just chose this because
                // it's a major city geographically between both countries.
  
  SAITAMA,      // Famous arena in Japan. Advantage for JAPAN, THAILAND
}

/*
  All Fighter countries:
  BRAZIL,
  CHINA,
  JAPAN,
  MEXICO,
  NETHERLANDS,
  NIGERIA,
  NORTH_KOREA,
  RUSSIA,
  THAILAND,
  USA

  10 total countries
*/