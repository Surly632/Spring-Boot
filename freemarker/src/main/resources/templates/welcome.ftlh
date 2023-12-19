<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome ${user}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1f1f1f; /* Dark background color */
            margin: 0;
            padding: 0;
            color: #fff; /* Default text color */
        }

        header {
            background-color: #003366; /* Dark blue color for the header */
            color: #fff;
            text-align: center;
            padding: 20px;
        }

        main {
            padding: 20px;
        }

        footer {
            background-color: #003366; /* Dark blue color for the footer */
            color: #fff;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        h1 {
            color: white; /* Dark blue color for the heading inside the header */
        }

        p {
            color: white; /* Lighter gray color for the paragraphs */
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome, ${user}!</h1>
    </header>
    <main>
        <p>List of Menus!</p>
        <p>
        <ul>
          <#list menus as menu>
          <li>${menu.name} - Price: ${menu.price} </li>
          </#list>
        </ul>
         </p>
         <p>

         </p>
    </main>
    <footer>
        <p>Best regards,<br> The Team</p>
    </footer>
</body>
</html>
