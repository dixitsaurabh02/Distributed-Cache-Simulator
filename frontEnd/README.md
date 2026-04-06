# 🚀 Distributed Cache Simulator

A Distributed Cache Simulator built using Spring Boot and React that demonstrates how data is stored and retrieved across multiple cache nodes using hashing and LRU (Least Recently Used) eviction policy.

---

## 🌐 Live Project
Check the live preview from the repository "About" section.

---

## ⚙️ Features

- 🔹 Distributed caching across multiple nodes  
- 🔹 Hash-based key distribution  
- 🔹 LRU cache eviction policy  
- 🔹 REST API integration  
- 🔹 Interactive frontend (React)  
- 🔹 Real-time cache visualization  

---

## 🧠 How It Works

- Data is stored using key-value pairs  
- A hash function determines which node stores the data  
- Each node has limited capacity  
- When full, least recently used data is removed  
- Data retrieval uses the same hashing mechanism  

---

## 🛠️ Tech Stack

- Backend: Spring Boot (Java)  
- Frontend: React.js  
- Architecture: Distributed System Simulation  

---

## 📌 Example

PUT:
apple → fruit  

GET:
apple → HIT ✅  

GET:
mango → MISS ❌  

---

## 🎯 Use Case

This project helps understand:
- Distributed systems  
- Caching strategies  
- Real-world system design concepts  

---

## 🔮 Future Improvements

- Add consistent hashing  
- Integrate Redis  
- Add visual node diagrams  
- Cache hit/miss analytics  

---

## 🧑‍💻 Author

Saurabh Dixit
