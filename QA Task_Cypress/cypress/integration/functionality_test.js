
describe('Functionality Test', function(){

it('Senario 1 to 5' , function(){

    cy.visit("https://react-shopping-cart-67954.firebaseapp.com/")

    cy.wait(2000)
    // Select on the XS button 
    cy.get(':nth-child(2) > label > .checkmark').click()

    cy.wait(2000)
    // Add to cart
    cy.get('.shelf-item__buy-btn').click()

   cy.wait(2000)
   cy.get('.shelf-item__details > .title').should('contain','T-Shirt')

   //Checkout button and Handel Alert
   cy.get('.buy-btn').click()
   cy.on('window:confirm',(str) =>
   {
       expect(str).to.equal('Checkout - Subtotal: $ 43.60')
    })
        

   //Close checkout
   cy.get('.float-cart__close-btn').click()


   //Un select the XS button 
   cy.get(':nth-child(2) > label > .checkmark').click()

   
   cy.wait(2000)
   //cy.get('#select').select('lowestprice')
   cy.get('select').select('lowestprice').should('be.visible').and('contain','low')


   cy.wait(2000)
   cy.scrollTo('bottom')

})

})