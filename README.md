# Homework 10
## Deadline for submission is in 2 weeks time

1. Follow instructions in [wiki](https://gitlab.fi.muni.cz/grp-pv256/wiki/wikis/home)
and proceed with forking this repo
2. Create Pokédex application
   * App consists of 2 screens - list of 151 Pokémon names, and a detail view for Pokémon
   * Get Pokémon data from [PokeAPI](https://pokeapi.co/docs/v2#pokemon)
   * All needed data classes for the model are prepared in `data` package
     * Don't remove any fields from the data classes
     * Detail page should display all Pokémon properties, except for sprites
     * As for sprites, display only `frontDefault`, if available
   * Main screen with Pokémon listing passes just Pokémon's name into its detail screen
     * First letter of Pokémon's name in the list (`RecyclerView`) should be capitalised
   * Both screens use `ViewModel` with `PokemonRepository`
     * `PokemonRepository` uses following pattern for data handling (for both screens):
       1. Start loading data, while doing so, supply cached values from DB, if present
       2. Fetch fresh data from the Internet and display them
       3. If fetching of the fresh data fails, supply cached version
       * You may use `Result` class for passing state with your data
   * App design is up to you, but do your best, and submit something worth looking at
   * Try to handle all possible error states -> **App should not be crashing** even when not connected to the Internet
   * Don't hardcode resources (styles, dimensions, strings, colors)
   * Use logging throughout the app
3. Prepare submission of the app to the Play store
   * Provide `jonas.sevcik@mail.muni.cz` your Google account, so you can be added to _Play Developer Console_
   * in the app's `build.gradle`, append an unique suffix to `applicationId`, like your faculty login
   * Prepare app listing
   * Fill in all required information, including screen shots and icons
   * Don't actually submit the app
4. **Optional (+2 points)**
   * implement paging (See [Paging Library](https://developer.android.com/topic/libraries/architecture/paging)) so you can load all Pokémons gradually
5. Submit changes into a **submit** branch and push it to your forked repo
6. Create a merge request against _your_ master branch and assign it to _qtokar_
Your commit must pass Gitlab CI verification. To test this locally, run:
```
./gradlew check
```
