# CODE-KATA-Shopping-Cart
This program gives the total price of the items inputted by users as a String.
The item list includes: A, B, C, D.
The user must enter the items as one string (no whitespaces allowed), and using only capital letters. Also, the user must only enter the items which are currently available in the supermarket. If any of these conditions are not satisfied - the exceptions will be raised.

The code is thoroughly tested for edge cases which can be found in the 'test' folder. The code is implemented with the re-usability in mind, so in case new items/new offers are added to the supermarket, they can just simply be added into the map, without adjusting the logic of the code.

## Workflow
- Treat this like a real assignment, but only spend up to two hours on it - it doesn't matter how far you get
- Fork the project to your personal Github account (click on the fork button in the top right corner)
- Clone the forked version of this repository
- Include a `README`
- Push your work up to your fork
- Submit a link to your forked repository

## Instructions
You should implement a supermarket checkout which:
- always accepts a string of items and gives back the total price
- discounts any offers from the total price

Use the following pricing information:

| Item  | Price | Offer     |
| :---: | :---: | :---:     |
| A     | 50    | 3 for 130 |
| B     | 30    | 2 for 37  |
| C     | 20    | N/A       |
| D     | 10    | N/A       |

For example:
- `'DABA'` gives `140`
- `'BBBB'` gives `74`
