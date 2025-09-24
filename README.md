# AI ChatBot (Android)

Android app (Java) with Welcome, Onboarding, Discover, and Notifications screens. Uses Firebase Authentication (email/password).

## Prerequisites
- Android Studio (Hedgehog+)
- JDK 11
- Firebase project

## Setup
1. Create Firebase project → add Android app with package `com.example.aichatbot`.
2. Download `google-services.json` and place at `app/google-services.json`.
3. Enable Authentication → Email/Password.
4. (Optional) Add debug SHA-1/256 to Firebase app settings.
5. Sync Gradle and Run.

## Features
- Welcome → Onboarding flow
- Email/password Sign Up & Sign In (Firebase Auth)
- Discover and Notifications placeholders

## Build
- Plugins: `com.android.application`, `com.google.gms.google-services`
- Versions via Firebase BOM

## Git hygiene
- `.gitignore` excludes build outputs and `app/google-services.json`.
