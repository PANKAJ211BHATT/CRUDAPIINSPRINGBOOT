import { useState, useEffect } from "react";

export default function App() {
  const [students, setStudents] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/student");
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      setStudents(data);
      setError(null);
    } catch (error) {
      console.error("Error fetching students:", error);
      setError("Failed to load students. Please try again later.");
    } finally {
      setLoading(false);
    }
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Students List</h1>
      {students.length === 0 ? (
        <p>No students found.</p>
      ) : (
        <div className="grid gap-4">
          {students.map((student) => (
            <div
              key={student.registeration_no}
              className="border p-4 rounded shadow"
            >
              <h2 className="font-bold">Name: {student.name}</h2>
              <p>Roll No: {student.roll_no}</p>
              <p>Email: {student.email}</p>
              <p>Phone: {student.phone}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}
