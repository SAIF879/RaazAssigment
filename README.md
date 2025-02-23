## 📌 Overview
Raaz Assignment is a Jetpack Compose-based Android application implementing authentication and a quiz section, with a main screen that includes a profile section, quiz responses, and user email display.

## 🏗 Tech Stack
- **Architecture**: MVVM (Model-View-ViewModel)
- **UI**: Jetpack Compose
- **Dependency Injection**: Dagger Hilt
- **Local Storage**: Room Database, DataStore Preferences
- **Configuration Management**: TOML

## 📂 Package Structure
```
com.example.raazassignment
│── data            # Data layer (Room, Retrofit, DataStore)
│   ├── local       # Room Database, DAO
│   ├── repository  # Repository implementations
│── domain          # Use cases and models
│── presentation    # UI Layer (Jetpack Compose Screens & ViewModels)
│   ├── navigation  # Navigation management
│   ├── ui          # Screens and components
│   ├── util        # Utility classes (DataStore, Extensions, etc.)
│── di              # Dagger Hilt dependency injection
│── RaazApplication # Application class
```

## 🚀 Features
### 🔐 Authentication (Local Storage)
- User registration & login
- Email and password saved in **Room Database**
- Last logged-in email stored in **DataStore Preferences**

### 📝 Quiz Section
- Users can take a quiz before accessing the main screen
- Quiz responses are stored in **Room Database**

### 🏠 Main Screen
- **Profile Section**: Displays user details
- **Quiz Responses**: Lists user's past quiz answers
- **AUTH SECTION**: User Login creds 

## ⚙️ Setup & Configuration
### 1️⃣ Clone Repository
```sh
git clone https://github.com/yourusername/RaazAssignment.git
cd RaazAssignment
```

### 2️⃣ Configure TOML File
Modify `config.toml` for API endpoints and settings:
```toml

### 3️⃣ Run the App
```sh
./gradlew assembleDebug
```

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
