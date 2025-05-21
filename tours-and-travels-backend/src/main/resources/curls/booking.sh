# Create Booking
curl --location 'http://127.0.0.1:8080/api/v1/bookings' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "tickets": 10,
    "ticketPrice": 2.5
}'

# Get Booking By Id
curl --location 'http://127.0.0.1:8080/api/v1/bookings/:bookingId' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'

# Get All Bookings
curl --location 'http://127.0.0.1:8080/api/v1/bookings' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'

# Delete Booking By Id
curl --location --request DELETE 'http://127.0.0.1:8080/api/v1/bookings/:bookingId' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'