states = ["Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"]
states = states.map {|a| a.upcase}
answered = []

puts "Name those states! Type 'help' for a list of commands!"

loop do
  answer = gets.chomp.to_s.upcase

  if answer.downcase == "help"
    puts "Type 'left' to see how many states are remaining."
    puts "Type 'list' to see an Alphabetic list of what you typed."
    puts "Type 'hint' to see the first letter of the next state."
  elsif answer.downcase == "left"
    puts "#{50 - answered.length}"
  elsif answer.downcase == "list"
    answered = answered.map {|a| a.capitalize}
    puts "#{answered.sort.join(", ")}"
  elsif answer.downcase == "hint"
    compare = 0
    
    answered = answered.map {|a| a.upcase}
    
    while states[compare] == answered[compare]
      compare += 1
    end
    
    puts states[compare].capitalize[0..0]    
  elsif states.include?(answer.upcase)
    if answered.include?(answer.upcase)
      puts "You already said #{answer.capitalize}!"
    else
      answered.push answer.upcase
    end
  else
    puts "That's not a state.. baka!"
  end

  break if answered.length == 50
end

puts "Congrats! You can name all 50 states!"