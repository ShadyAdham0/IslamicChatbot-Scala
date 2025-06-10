# 🕌 Islamic Chatbot (Scala) 

<div align="center">

[![Scala](https://img.shields.io/badge/Scala-3.x-red.svg)](https://www.scala-lang.org/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Islamic Content](https://img.shields.io/badge/Content-Islamic-green.svg)]()

An interactive command-line chatbot that answers questions about Islam and provides educational quizzes. Built with Scala, this chatbot aims to help users learn about Islamic concepts, practices, and teachings in an engaging way.

</div>

---

## ✨ Features

- 🤖 **Interactive Q&A**: Ask questions about Islamic concepts, practices, and teachings
- 📝 **Educational Quizzes**: Test your knowledge with built-in quizzes
- 🎯 **Multiple Difficulty Levels**: Choose between easy, medium, and hard questions
- 📚 **Topic-Based Learning**: Focus on specific topics of interest
- 📖 **Detailed Explanations**: Learn from comprehensive explanations for quiz answers
- 🎨 **User-Friendly Interface**: Simple and intuitive command-line interface
- 📜 **Authentic Sources**: All content sourced from reliable Islamic references

## 🚀 Prerequisites

- ☕ Java Runtime Environment (JRE) 8 or higher
- 🔷 Scala 3.x
- 🛠️ SBT (Scala Build Tool)

## ⚙️ Installation

1. Clone the repository:
```bash
git clone https://github.com/ShadyAdham0/IslamicChatbot-Scala.git
cd IslamicChatbot-Scala
```

2. Run the project:
```bash
scala src/main/scala/Main.scala src/main/scala/services/*.scala src/main/scala/models/*.scala
```

## 📖 Usage

### 🎮 Available Commands

- 💬 Ask any question about Islam (e.g., "What is Salah?", "What are the five pillars of Islam?")
- 📝 `quiz` - Start a general quiz session
- 🎯 `quiz <topic>` - Start a quiz on a specific topic (e.g., `quiz Prayer`, `quiz Ramadan`)
- ⚡ `difficulty <level>` - Set quiz difficulty (easy/medium/hard)
- 💡 `explanations <on/off>` - Toggle quiz explanations
- ℹ️ `help` - Show all available commands
- 🚪 `exit` - Exit the program

### 💭 Example Interactions

<details>
<summary>Click to see example interactions</summary>

```
You: What is Ramadan?
Bot: Ramadan is the ninth month of the Islamic calendar when Muslims fast from dawn 
    to sunset. It is a time of spiritual reflection, increased charity and worship, 
    and reading of the Quran.
Source: Quran 2:183-185

You: quiz Pillars
Bot: Starting quiz session...
Difficulty: easy
Topic: Pillars
Answer by typing the number of your choice (1-4)

Question 1:
1. Shahada
2. Salah
3. Zakat
4. All of the above

Your answer (1-4): 4
Correct! Masha Allah!
Explanation: The five pillars of Islam are Shahada (declaration of faith), 
Salah (prayer), Zakat (charity), Sawm (fasting), and Hajj (pilgrimage).
```
</details>

## 🗂️ Project Structure

```
IslamicChatbot-Scala/
├── 📁 src/main/scala/           # Source code
│   ├── 📜 Main.scala           # Entry point
│   ├── 📁 services/            # Business logic
│   │   ├── 📜 ChatService.scala
│   │   ├── 📜 FileService.scala
│   │   ├── 📜 QuizService.scala
│   │   └── 📜 UserPreferences.scala
│   └── 📁 models/              # Data models
│       └── 📜 Response.scala
├── 📁 data/                    # Data files
│   ├── 📜 keywords.json       # Keywords for matching
│   ├── 📜 responses.csv      # Chat responses
│   └── 📜 quizzes.csv       # Quiz questions
└── 📜 build.sbt              # Project configuration
```

## 📚 Data Sources

The chatbot's responses and quiz questions are sourced from authentic Islamic references:

- 📖 The Holy Quran
- 📗 Sahih Al-Bukhari
- 📘 Sahih Muslim
- 📙 Other authentic Islamic sources

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. 📝 Add more Q&A pairs to `data/responses.csv`
2. ❓ Add new quiz questions to `data/quizzes.csv`
3. 🔍 Improve keyword matching in `data/keywords.json`
4. 💻 Enhance the code functionality

> **Important**: Please ensure all contributions are based on authentic Islamic sources.

## ⚖️ License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- 👥 Thanks to all contributors who help improve the Islamic knowledge base
- 💫 Special thanks to the Scala community for the excellent tools and libraries

---

<div align="center">

Made with ❤️ for the Muslim Ummah

</div>
