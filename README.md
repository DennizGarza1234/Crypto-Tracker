# CryptoTracker

CryptoTracker is an Android application built with Kotlin that fetches and displays real-time cryptocurrency market data using the CoinGecko API. The app demonstrates the use of modern Android development tools including RecyclerView, Kotlin Coroutines, and the Ktor HTTP client.

---

## Features

* Live cryptocurrency market data (top 10 coins)
* Displays:

  * Coin name
  * Symbol
  * Current price (USD)
  * 24h percentage change
* Loading indicator while fetching data
* Clean and simple RecyclerView UI
* Asynchronous network calls using Kotlin Coroutines
* API integration using Ktor Client

---

## Tech Stack

* **Kotlin**
* **Android SDK**
* **RecyclerView**
* **Kotlin Coroutines**
* **Ktor Client**
* **CoinGecko API**

---

## API Used

This app uses the CoinGecko Markets API:

```
https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=10&page=1
```

---

## App Structure

* **MainActivity**

  * Fetches data from API
  * Handles UI updates
  * Manages loading state

* **CryptoAdapter**

  * Binds cryptocurrency data to RecyclerView items

* **CryptoCoin Model**

  * Represents API response data structure

* **KtorClient**

  * Handles HTTP requests

---

## Test Cases

### Normal Cases

1. **App Launch**

   * App loads and displays top 10 cryptocurrencies successfully.

2. **Data Display**

   * Coin name, symbol, price, and 24h change are correctly shown.

3. **Scrolling Behavior**

   * RecyclerView scrolls smoothly without lag or crashes.

---

### Edge Cases

1. **No Internet Connection**

   * App handles network failure without crashing.

2. **Slow Network**

   * Loading spinner remains visible until data is fetched.

3. **Empty API Response**

   * App safely handles empty or missing data.

---

## Setup Instructions

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or physical device

---

## Demo

(Insert your video or screenshots here)

---

## Youtube
https://www.youtube.com/watch?v=tZW7py9Gw18

---

## Author

Created as a learning project to demonstrate Android networking, RecyclerView usage, and API integration.

---

## Notes

* Built for educational purposes
* Uses live market data from CoinGecko
