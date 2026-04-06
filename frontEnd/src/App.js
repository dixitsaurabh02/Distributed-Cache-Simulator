import React, { useState } from "react";

const BASE_URL = "https://69c7d952efe8729af097cb7f-api-capstone.myanatomy.ai/cache";

function App() {
  const [key, setKey] = useState("");
  const [value, setValue] = useState("");
  const [getKey, setGetKey] = useState("");
  const [output, setOutput] = useState("");

  const putData = async () => {
    const res = await fetch(BASE_URL + "/put", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ key, value }),
    });

    const text = await res.text();
    setOutput(text);
  };

  const getData = async () => {
    const res = await fetch(BASE_URL + "/get/" + getKey);
    const text = await res.text();
    setOutput(text);
  };

  const loadAll = async () => {
    const res = await fetch(BASE_URL + "/all");
    const data = await res.json();
    setOutput(JSON.stringify(data, null, 2));
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>🚀 Distributed Cache Simulator</h1>

      <div style={{ marginBottom: "20px" }}>
        <h3>Put Key-Value</h3>
        <input
          placeholder="Key"
          value={key}
          onChange={(e) => setKey(e.target.value)}
        />
        <input
          placeholder="Value"
          value={value}
          onChange={(e) => setValue(e.target.value)}
          style={{ marginLeft: "10px" }}
        />
        <button onClick={putData} style={{ marginLeft: "10px" }}>
          PUT
        </button>
      </div>

      <div style={{ marginBottom: "20px" }}>
        <h3>Get Value</h3>
        <input
          placeholder="Key"
          value={getKey}
          onChange={(e) => setGetKey(e.target.value)}
        />
        <button onClick={getData} style={{ marginLeft: "10px" }}>
          GET
        </button>
      </div>

      <div style={{ marginBottom: "20px" }}>
        <h3>View All Cache Nodes</h3>
        <button onClick={loadAll}>SHOW ALL</button>
      </div>

      <div>
        <h3>Output:</h3>
        <pre style={{ background: "#f4f4f4", padding: "10px" }}>
          {output}
        </pre>
      </div>
    </div>
  );
}

export default App;