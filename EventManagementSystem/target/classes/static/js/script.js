function registerUser() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch('/api/users/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, email, password }),
    })
    .then(response => response.json())
    .then(data => {
        alert('Registration successful');
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function loginUser() {
    const email = document.getElementById('login-email').value;
    const password = document.getElementById('login-password').value;

    fetch('/api/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
function createEvent() {
    const title = document.getElementById('event-title').value;
    const description = document.getElementById('event-description').value;
    const date = document.getElementById('event-date').value;
    const time = document.getElementById('event-time').value;
    const location = document.getElementById('event-location').value;
    const ticketInfo = document.getElementById('event-ticket-info').value;

    fetch('/api/events/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title, description, date, time, location, ticketInfo }),
    })
    .then(response => response.json())
    .then(data => {
        alert('Event created successfully');
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
function getEventsByOrganizer(organizerId) {
    fetch(`/api/events/organizer/${organizerId}`)
    .then(response => response.json())
    .then(events => {
        const eventsList = document.getElementById('events-list');
        eventsList.innerHTML = '';
        events.forEach(event => {
            const eventItem = document.createElement('div');
            eventItem.className = 'event-item';
            eventItem.innerHTML = `
                <h3>${event.title}</h3>
                <p>${event.description}</p>
                <button onclick="updateEvent(${event.id})">Update</button>
            `;
            eventsList.appendChild(eventItem);
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function updateEvent(eventId) {
    const title = prompt("Enter new title:");
    const description = prompt("Enter new description:");
    fetch('/api/events/update', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ id: eventId, title, description }),
    })
    .then(response => response.json())
    .then(data => {
        alert('Event updated successfully');
        getEventsByOrganizer(1); // Assuming organizerId is 1
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

// Call this function on page load
getEventsByOrganizer(1); // Assuming organizerId is 1
function searchEvents() {
    const keyword = document.getElementById('search-keyword').value;
    fetch(`/api/events/search?keyword=${keyword}`)
    .then(response => response.json())
    .then(events => {
        const searchResults = document.getElementById('search-results');
        searchResults.innerHTML = '';
        events.forEach(event => {
            const eventItem = document.createElement('div');
            eventItem.className = 'event-item';
            eventItem.innerHTML = `
                <h3>${event.title}</h3>
                <p>${event.description}</p>
                <p>${event.date} ${event.time}</p>
                <p>${event.location}</p>
                <p>${event.ticketInfo}</p>
            `;
            searchResults.appendChild(eventItem);
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
function purchaseTicket() {
    const eventId = document.getElementById('event-id').value;
    const userId = document.getElementById('user-id').value;
    const ticketType = document.getElementById('ticket-type').value;
    const price = document.getElementById('ticket-price').value;

    fetch('/api/tickets/purchase', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ eventId, userId, ticketType, price }),
    })
    .then(response => response.json())
    .then(data => {
        alert('Ticket purchased successfully');
    })
    .catch(error => {
        console.error('Error:', error);
    });
}


